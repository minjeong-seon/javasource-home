package user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor
@ToString @Getter @Setter

public class UserDTO {
	private int no;
	private String username;
	private int birthYear;
	private String addr;
	private String mobile;
}
