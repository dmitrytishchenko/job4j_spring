package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AccidentMem {
    private static final AccidentMem INST = new AccidentMem();
    private Map<Integer, Accident> accidents = new HashMap<Integer, Accident>();

    private AccidentMem() {
        this.accidents.put(1, new Accident(1, "Александр", "Сплошная", "ул. Вавилова"));
        this.accidents.put(2, new Accident(2, "Алексей", "Светофор", "ул. Мира"));
        this.accidents.put(3, new Accident(3, "Александр", "Пешеходный переход", "ул. Курчатова"));
    }

    public static AccidentMem InstOf() {
        return INST;
    }

    public Collection<Accident> getAccidents() {
        return accidents.values();
    }
}

