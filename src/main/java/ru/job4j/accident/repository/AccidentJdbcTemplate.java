package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;

//@Repository
//public class AccidentJdbcTemplate {
//    private final JdbcTemplate jdbc;
//
//    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }
//
//    public Accident save(Accident accident) {
//        jdbc.update("insert into accident (name, text, address) values (?, ? , ?)",
//                accident.getName(), accident.getText(), accident.getAddress());
//        return accident;
//    }
//
//    public Accident update(Accident accident) {
//        jdbc.update("update accident set name=?, text=?, address=? where id=?",
//                accident.getName(), accident.getText(), accident.getAddress(), accident.getId());
//        return accident;
//    }
//
//    public void delete(int id) {
//        jdbc.update("delete from accident where id=?", id);
//    }
//
//    public Accident getAccident(int id) {
//        return jdbc.queryForObject("select * from accident where id=?", Accident.class, id);
//
//    }
//
//    public List<Accident> getAll() {
//        return jdbc.query("select id, name, text, address from accident",
//                (rs, row) -> {
//                    Accident accident = new Accident();
//                    accident.setId(rs.getInt("id"));
//                    accident.setName(rs.getString("name"));
//                    accident.setText(rs.getString("text"));
//                    accident.setAddress(rs.getString("address"));
//                    return accident;
//                });
//    }
//}
