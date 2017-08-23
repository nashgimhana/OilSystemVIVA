/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.util.List;
import pojo.Attendence;
import pojo.AttenenceLog;

/**
 *
 * @author Me
 */
public class AttendanceLog {

    public pojo.AttenenceLog getBy(int id) {
        return null;
    }

    public List<pojo.AttenenceLog> getBy(pojo.Employee employee) {
        return null;
    }
/**
 * 
 * @param attendance
 * @return return a String object, values as "not", "done", "error"
 */
    public String save(pojo.Attendence attendance) {
        return "not";
    }
/**
 * 
 * @param attendance
 * @return return a String object, values as "not", "done", "error"
 */
    public String update(pojo.Attendence attendance) {
        return "not";
    }
}
