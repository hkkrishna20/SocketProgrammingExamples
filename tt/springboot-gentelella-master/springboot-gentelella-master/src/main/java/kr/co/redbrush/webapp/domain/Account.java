package kr.co.redbrush.webapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(of = "userId")
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
public class Account {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true, length = 50)
    private String userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int passwordFailureCount;

    @Column
    private LocalDateTime passwordUpdatedDate;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private boolean locked;

    @Column(nullable = false)
    private boolean activated;

    @Column
    private LocalDateTime lastLogin;

    @Column
    private LocalDateTime activatedDate;

    @CreatedDate
    @Column
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column
    private LocalDateTime updatedDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "account_roles",
            joinColumns = {@JoinColumn(name="account_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
    )
    private List<Role> roles;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "account")
    private Profile profile;
}
