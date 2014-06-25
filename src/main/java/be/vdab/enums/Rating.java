package be.vdab.enums;

public enum Rating {
	G("G"), PG("PG"), PG13("PG-13"), R("R"), NC17("NC-17");
	private String rating;

	private Rating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return rating;
	}
}
