package com.metanet.educationSystem.model;


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
	private String memberName;
	private String memberPassword;
	private String memberEmail;
	private String memberPhoneNO;

	private String memberDistinct; //parameter ��Ȯ�� ����...
	private Collection<GrantedAuthority> authorities;
	
	
	public MemberVO() {
		this.memberNO = null;
		this.memberName = null;
		this.memberPassword = null;
		this.memberEmail = null;
		this.memberPhoneNO = null;
		this.memberDistinct = null;
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
	}
}
