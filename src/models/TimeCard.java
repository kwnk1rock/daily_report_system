package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "TimeCards")
@NamedQueries({
    @NamedQuery(
            name = "getAllTimeCards",
            query = "SELECT t FROM TimeCard AS t ORDER BY t.id DESC"
            ),
    @NamedQuery(
            name = "getMyTimeCards",
            query = "SELECT t FROM TimeCard AS t WHERE t.employee = :employee ORDER BY t.id DESC"
    )
})
@Entity
public class TimeCard {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tc_employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "tc_report_id", nullable = false)
    private Report report;

    @Column(name = "started_at")
    private Timestamp started_at;

    @Column(name = "ended_at")
    private Timestamp ended_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Timestamp getStarted_at() {
        return started_at;
    }

    public void setStarted_at(Timestamp started_at) {
        this.started_at = started_at;
    }

    public Timestamp getEnded_at() {
        return ended_at;
    }

    public void setEnded_at(Timestamp ended_at) {
        this.ended_at = ended_at;
    }
}
