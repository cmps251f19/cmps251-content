package inheritance.member;

import java.util.ArrayList;
import java.util.List;

public class Department {
		private List<Member> members = new ArrayList<>();
		
		public Department() {
		}
		
		public void addMember(Member member) {
			members.add(member);
		}

		public List<Member> getMembers() {
			return members;
		}
}
