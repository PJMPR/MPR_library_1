package library.domain;

import java.util.Calendar;
import java.util.Date;


public class Reservation {
    private int id;
    private Calendar ReservationDate;
    private Calendar RetirvalDate;
    private Calendar RealDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getReservationDate() {
        return ReservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        ReservationDate = reservationDate;
    }

    public Calendar getRetirvalDate() {
        return RetirvalDate;
    }

    public void setRetirvalDate(Date retirvalDate) {
        RetirvalDate = retirvalDate;
    }

    public Calendar getRealDate() {
        return RealDate;
    }

    public void setRealDate(Date realDate) {
        RealDate = realDate;
    }
}
