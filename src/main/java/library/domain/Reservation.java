package library.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Reservation implements IHaveId{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "reservation_date")
    private Date ReservationDate;
	
	@Column(name = "retrival_date")
    private Date RetirvalDate;
	
	@Column(name = "real_date")
    private Date RealDate;

    @ManyToMany(mappedBy = "reservations")
    private List<Book> books;
    
    public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

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
