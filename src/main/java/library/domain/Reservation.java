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

    public void setReservationDate(Calendar reservationDate) {
        ReservationDate = reservationDate;
    }

    public Calendar getRetirvalDate() {
        return RetirvalDate;
    }

    public void setRetirvalDate(Calendar retirvalDate) {
        RetirvalDate = retirvalDate;
    }

    public Calendar getRealDate() {
        return RealDate;
    }

    public void setRealDate(Calendar realDate) {
        RealDate = realDate;
    }
}
