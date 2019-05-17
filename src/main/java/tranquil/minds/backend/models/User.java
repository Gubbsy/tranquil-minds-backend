package tranquil.minds.backend.models;

import org.hibernate.annotations.DynamicUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 * JPA Entity defining a User object
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor //JPA only
@DynamicUpdate // More efficient, update statement only updates changed fields
@Table(name="T_USER", uniqueConstraints={@UniqueConstraint(columnNames={"USER_ID", "EMAIL"})})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Column(name = "SALUTATION", length = 50)
    private String title;

    @Column(name = "FIRST_NAME", nullable = false, length = 200)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 100)
    private String lastName;

    @Column(name = "TEL_NO" , columnDefinition = "CHAR(20)")
    private String tel;

    @Column(name = "EMAIL", nullable = false, length = 60)
    private String email;

    @Column(name = "CREATED", nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp creationDate;

    @Column(name = "LAST_LOGIN", nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastSeen;

    @PostLoad
    protected void trimAll(){
        if(tel!=null)tel=tel.trim();
    }
}