package models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Роман on 19.02.2017.
 *
 *
 */
@Entity
public class Note implements Serializable,Comparable<Note>{

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private int id;

    @Column
    private char aChar;

    @Column
    private String varchar;

    @Column
    private int integer;

    @Column
    @Temporal(value = TemporalType.DATE)
    private Date date;

    public Note() {
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public String getVarchar() {
        return varchar;
    }

    public void setVarchar(String varchar) {
        this.varchar = varchar;
    }

    @Override
    public int compareTo(Note o) {
        return Integer.compare(this.id, o.getId());
    }

    @Override
    public String toString() {
        return "Note{" +
                "aChar=" + aChar +
                ", id=" + id +
                ", varchar='" + varchar + '\'' +
                ", integer=" + integer +
                ", date=" + date +
                '}';
    }
}
