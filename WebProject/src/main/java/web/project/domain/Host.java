package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity implementation class for Entity: Host
 *
 */
@Entity
@Getter
@Setter
public class Host implements Serializable {

	
	private static final long serialVersionUID = 1L;

   @Id
   @Column(name="HOST_ID")
   private String host_id;
   private String password;
   private String email;
   private String nickname;
   private String gender;
   private String address; 
   private String post;
   private String profile;
}
