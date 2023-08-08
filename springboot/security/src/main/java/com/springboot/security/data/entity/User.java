package com.springboot.security.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String uid; // 회원 ID (JWT 토큰 내 정보)

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Json결과로 해당필드는 오직 쓰려는 경우에만 접근이 허용
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER) // 컬렉션 타입의 컬럼임을 알려줌. 1:N 연관관계 다룸.
    @Builder.Default // 객체를 원하는 타입과 값으로 초기화 할 때(즉 빌더패턴을 통해 인스턴스를 만들 때 특정필드를 특정값으로 초기화하고 싶다면)
    private List<String> roles = new ArrayList();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // 계정이 가지고 있는 권한 목록을 리턴
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getUsername(){
        return this.uid; // security 에서 사용하는 회원 구분 id
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired(){
        return true;  // 계정이 만료되었는지 체크하는 로직. 이 예제에서는 사용하지 않으므로 true값 리턴
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정이 잠겼는지 체크하는 로직. 이 예제에서는 사용하지 않으므로 true값 리턴
    }
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 계정의 패스워드가 만료되었는지 체크하는 로직. 이 예제에서는 사용하지 않으므로 true값 리턴
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true; // 계정이 사용가능한지 체크하는 로직. 이 예제에서는 사용하지 않으므로 true값 리턴
    }
}
