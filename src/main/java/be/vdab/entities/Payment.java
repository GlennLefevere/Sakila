package be.vdab.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "payment")
public class Payment{
	@Id
	@GeneratedValue
	@Column(name = "payment_id")
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id")
	private Staff staff;
	private BigDecimal amount;
	@Temporal(TemporalType.DATE)
	@Column(name="payment_date")
	private Date paymentDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	@ManyToOne
	@JoinColumn(name="rental_id")
	private Rental rental;
	
	public Payment(){}

	public Payment(long id, Customer customer, Staff staff, BigDecimal amount, Date paymentDate, Date lastUpdate, Rental rental) {
		this.id = id;
		this.customer = customer;
		this.staff = staff;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.lastUpdate = lastUpdate;
		this.rental = rental;
	}

	public long getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Staff getStaff() {
		return staff;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public Rental getRental() {
		return rental;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result + ((rental == null) ? 0 : rental.hashCode());
		result = prime * result + ((staff == null) ? 0 : staff.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (rental == null) {
			if (other.rental != null)
				return false;
		} else if (!rental.equals(other.rental))
			return false;
		if (staff == null) {
			if (other.staff != null)
				return false;
		} else if (!staff.equals(other.staff))
			return false;
		return true;
	}
}
