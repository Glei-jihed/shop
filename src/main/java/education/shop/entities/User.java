package education.shop.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2",strategy = "uuid2")
    private String id;


    @Column(name = "first_name", nullable = false)
    private String firstName;


    @Column(name = "last_name", nullable = false)
    private String lastName;


    @Column(name = "age", nullable = false)
    private int age;


    @Temporal(TemporalType.DATE)
    private Date inscriptionDate;


    @Column(unique = true, name = "email", nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean connected;

    @Column(nullable = false)
    private String city;


    @Column(nullable = false)
    private Integer postalCode;



    @Column(unique = true, nullable = false, name = "phone")
    private String phone;


    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Lob
    private byte[] profilePicture;


    @OneToOne(mappedBy = "user")
    @JoinColumn(name = "user_id", nullable = false)
    private Cart cart;

    public User(String number, String jihed, String glei, int i, String paris, int i1, String mail, String s, String number1, boolean b) {
    }


    //================================================ Pre persist =====================================================

    @PrePersist
    public void prePersist(){
        this.inscriptionDate= new Date();
        this.cart=new Cart();
    }

    //================================================= User details ===================================================


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
