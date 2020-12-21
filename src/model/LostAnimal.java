package model;

public class LostAnimal {
	
	int receiptNum;
	String animalType;
	String ownerName;
	String ownerPhone;
	String animalSpecies;
	int animalAge;
	String animalGender;
	String progress;
	String region;
	
	
	
	public LostAnimal(String animalType, String ownerName, String ownerPhone, String animalSpecies, int animalAge,
			String animalGender, String region) {
		super();
		this.animalType = animalType;
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.animalSpecies = animalSpecies;
		this.animalAge = animalAge;
		this.animalGender = animalGender;
		this.region = region;
	}



	public LostAnimal(int receiptNum, String animalType, String ownerName, String ownerPhone, String animalSpecies,
			int animalAge, String animalGender, String progress) {
		super();
		this.receiptNum = receiptNum;
		this.animalType = animalType;
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.animalSpecies = animalSpecies;
		this.animalAge = animalAge;
		this.animalGender = animalGender;
		this.progress = progress;
	}



	public LostAnimal(int receiptNum, String animalType, String ownerName, String ownerPhone, String animalSpecies,
			int animalAge, String animalGender, String progress, String region) {
		super();
		this.receiptNum = receiptNum;
		this.animalType = animalType;
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.animalSpecies = animalSpecies;
		this.animalAge = animalAge;
		this.animalGender = animalGender;
		this.progress = progress;
		this.region = region;
	}



	public void setReceiptNum(int receiptNum) {
		this.receiptNum = receiptNum;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public void setAnimalSpecies(String animalSpecies) {
		this.animalSpecies = animalSpecies;
	}
	public void setAnimalAge(int animalAge) {
		this.animalAge = animalAge;
	}
	public void setAnimalGender(String animalGender) {
		this.animalGender = animalGender;
	}
	
	public void setProgress(String progress) {
		this.progress = progress;
	}

	public void setRegion(String region) {
		this.region = region;
	}



	public int getReceiptNum() {
		return receiptNum;
	}

	public String getAnimalType() {
		return animalType;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public String getOwnerPhone() {
		return ownerPhone;
	}
	public String getAnimalSpecies() {
		return animalSpecies;
	}
	public int getAnimalAge() {
		return animalAge;
	}
	public String getAnimalGender() {
		return animalGender;
	}

	public String getProgress() {
		return progress;
	}

	public String getRegion() {
		return region;
	}



	@Override
	public String toString() {
		return "LostAnimal [receiptNum=" + receiptNum + ", animalType=" + animalType + ", ownerName=" + ownerName
				+ ", ownerPhone=" + ownerPhone + ", animalSpecies=" + animalSpecies + ", animalAge=" + animalAge
				+ ", animalGender=" + animalGender + ", progress=" + progress + ", region=" + region + "]";
	}

	
	
	
	

}
