package library.domain;

import java.util.Date;

/**
 * Created by Kuba on 04.10.2017.
 */
public class Reservation {
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
