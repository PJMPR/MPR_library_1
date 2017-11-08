package library.domain;

import java.sql.Date;



public class Reservation implements IHaveId{
    private int id;
    private Date ReservationDate;
    private Date RetirvalDate;
    private Date RealDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return ReservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        ReservationDate = reservationDate;
    }

    public Date getRetirvalDate() {
        return RetirvalDate;
    }

    public void setRetirvalDate(Date retirvalDate) {
        RetirvalDate = retirvalDate;
    }

    public Date getRealDate() {
        return RealDate;
    }

    public void setRealDate(Date realDate) {
        RealDate = realDate;
    }
}
