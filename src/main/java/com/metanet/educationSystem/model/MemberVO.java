package com.metanet.educationSystem.model;

<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private int memberNO;
=======
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO implements UserDetails{
	@Override
	public String toString() {
		return "MemberVO [memberNO=" + memberNO + ", memberName=" + memberName + ", memberPassword=" + memberPassword
				+ ", memberEmail=" + memberEmail + ", memberPhoneNO=" + memberPhoneNO + ", memberDistinct="
				+ memberDistinct + ", authorities=" + authorities + "]";
	}

	private String memberNO;
>>>>>>> fb472a3bec218c8780ec34ae326bfcaf0f15b740
	private String memberName;
	private String memberPassword;
	private String memberEmail;
	private String memberPhoneNO;
<<<<<<< HEAD
	private int memberDistinct; //parameter ï¿½ï¿½È®ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½...
	
	
	public MemberVO() {
		this.memberNO = 0;
=======
	private String memberDistinct; //parameter Á¤È®È÷ Á¤ÀÇ...
	private Collection<GrantedAuthority> authorities;
	
	
	public MemberVO() {
		this.memberNO = null;
>>>>>>> fb472a3bec218c8780ec34ae326bfcaf0f15b740
		this.memberName = null;
		this.memberPassword = null;
		this.memberEmail = null;
		this.memberPhoneNO = null;
<<<<<<< HEAD
		this.memberDistinct = 0; 
=======
		this.memberDistinct = null; //Á¤È®È÷ Á¤ÀÇ
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
 }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return memberPassword;
	}

	@Override
	public String getUsername() {
		return memberNO;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
>>>>>>> fb472a3bec218c8780ec34ae326bfcaf0f15b740
	}
}
