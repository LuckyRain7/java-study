package com.example.java.learn.lang;

import java.util.Arrays;

public class OverrideHashcodeAndEquals {

	private short ashort;
	private char achar;
	private byte abyte;
	private boolean abool;
	private long along;
	private float afloat;
	private double adouble;
	private Object anObject = new Object();
	private int[] ints;
	private Object[] objects;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (abool ? 1231 : 1237);
		result = prime * result + abyte;
		result = prime * result + achar;
		long temp;
		temp = Double.doubleToLongBits(adouble);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(afloat);
		result = prime * result + (int) (along ^ (along >>> 32));
		result = prime * result + ((anObject == null) ? 0 : anObject.hashCode());
		result = prime * result + ashort;
		result = prime * result + Arrays.hashCode(ints);
		result = prime * result + Arrays.hashCode(objects);
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
		OverrideHashcodeAndEquals other = (OverrideHashcodeAndEquals) obj;
		if (abool != other.abool)
			return false;
		if (abyte != other.abyte)
			return false;
		if (achar != other.achar)
			return false;
		if (Double.doubleToLongBits(adouble) != Double.doubleToLongBits(other.adouble))
			return false;
		if (Float.floatToIntBits(afloat) != Float.floatToIntBits(other.afloat))
			return false;
		if (along != other.along)
			return false;
		if (anObject == null) {
			if (other.anObject != null)
				return false;
		} else if (!anObject.equals(other.anObject))
			return false;
		if (ashort != other.ashort)
			return false;
		if (!Arrays.equals(ints, other.ints))
			return false;
		if (!Arrays.equals(objects, other.objects))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OverrideHashcode [ashort=" + ashort + ", achar=" + achar + ", abyte=" + abyte + ", abool=" + abool
				+ ", along=" + along + ", afloat=" + afloat + ", adouble=" + adouble + ", anObject=" + anObject
				+ ", ints=" + Arrays.toString(ints) + ", objects=" + Arrays.toString(objects) + "]";
	}

	public short getAshort() {
		return ashort;
	}

	public void setAshort(short ashort) {
		this.ashort = ashort;
	}

	public char getAchar() {
		return achar;
	}

	public void setAchar(char achar) {
		this.achar = achar;
	}

	public byte getAbyte() {
		return abyte;
	}

	public void setAbyte(byte abyte) {
		this.abyte = abyte;
	}

	public boolean isAbool() {
		return abool;
	}

	public void setAbool(boolean abool) {
		this.abool = abool;
	}

	public long getAlong() {
		return along;
	}

	public void setAlong(long along) {
		this.along = along;
	}

	public float getAfloat() {
		return afloat;
	}

	public void setAfloat(float afloat) {
		this.afloat = afloat;
	}

	public double getAdouble() {
		return adouble;
	}

	public void setAdouble(double adouble) {
		this.adouble = adouble;
	}

	public Object getAnObject() {
		return anObject;
	}

	public void setAnObject(Object anObject) {
		this.anObject = anObject;
	}

	public int[] getInts() {
		return ints;
	}

	public void setInts(int[] ints) {
		this.ints = ints;
	}

	public Object[] getObjects() {
		return objects;
	}

	public void setObjects(Object[] objects) {
		this.objects = objects;
	}

}
