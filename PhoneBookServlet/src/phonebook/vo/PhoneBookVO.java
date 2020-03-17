package phonebook.vo;

public class PhoneBookVO {

	private Long phoneId;
	private String phoneName;
	private String phoneHp;
	private String phoneTel;
	
	
	public PhoneBookVO(String name, String hp, String tel) {
		phoneName = name;
		phoneHp = hp;
		phoneTel = tel;
	} 
	
	public PhoneBookVO(Long id, String name, String hp, String tel) {
	
		phoneId = id;
		phoneName = name;
		phoneHp = hp;
		phoneTel = tel;
		
	}
		
	public Long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}

	public String getPhoneHp() {
		return phoneHp;
	}

	public void setPhoneHp(String phoneHp) {
		this.phoneHp = phoneHp;
	}

	public String getPhoneTel() {
		return phoneTel;
	}

	public void setPhoneTel(String phoneTel) {
		this.phoneTel = phoneTel;
	}

	
	
	
	@Override
	public String toString() {
		return  phoneId  +" "+  phoneName +" "+ phoneHp + " "
				+ phoneTel ;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PhoneBookVO) {
			PhoneBookVO other = (PhoneBookVO)obj;
			return this.phoneId == other.phoneId;
		}
		return super.equals(obj);
	}

	
	
}
