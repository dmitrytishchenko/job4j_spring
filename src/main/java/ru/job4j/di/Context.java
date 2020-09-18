package ru.job4j.di;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    /**
     * Карта с объектами, лежат проинициализированные объекты
     */
    private Map<String, Object> els = new HashMap<String, Object>();

    /**
     * Метод регистрации класса
     */
    public void reg(Class cl) {
        /**
         * Сначала получаем все конструкторы класса.
         * Если их более 1 - то кидаем исключение
         */
        Constructor[] constructors = cl.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalStateException("Class has multiple constructors : " + cl.getCanonicalName());
        }
        /**
         * Когда нашли конструктор, собираем аргументы и ищем зарегистрированные объеты, чтобы внедрить их в объекты
         */
        Constructor con = constructors[0];
        List<Object> args = new ArrayList<Object>();
        for (Class arg : con.getParameterTypes()) {
            if (!els.containsKey(arg.getCanonicalName())) {
                throw new IllegalStateException("Object doesn't found in context : " + arg.getCanonicalName());
            }
            args.add(els.get(arg.getCanonicalName()));
        }
        /**
         * создание объекта и добавление его в карту
         */
        try {
            els.put(cl.getCanonicalName(), con.newInstance(args.toArray()));
        } catch (Exception e) {
            throw new IllegalStateException("Coun't create an instance of : " + cl.getCanonicalName(), e);
        }
    }

    /**
     * Метод возвращает проинициализированный объект
     */
    public <T> T get(Class<T> inst) {
        return (T) els.get(inst.getCanonicalName());
    }
}
