package member.model;

import java.util.List;

public class MemberListView {

	private int memberTotalCount;
	private int memberCountPerPage;
	private List<Member> memberList;
	private int pageTotalCount;
	private int firstRow;
	private int pageNumber;
	public MemberListView(int memberTotalCount, 
			              int memberCountPerPage, 
			              List<Member> memberList, 
			              int firstRow,
			              int pageNumber) {

		this.memberTotalCount = memberTotalCount;
		this.memberCountPerPage = memberCountPerPage;
		this.memberList = memberList;
		this.firstRow = firstRow;
		this.pageNumber = pageNumber;
		calTotalPageCount(); 
	}
	
	private void calTotalPageCount() {
		
		if(memberTotalCount == 0) {
			pageTotalCount =0;
		}else {
		pageTotalCount = memberTotalCount/memberCountPerPage;
		pageTotalCount = memberTotalCount%memberCountPerPage>0 ? ++pageTotalCount : pageTotalCount;
		//pageTotalCount = pageTotalCount++
		//pageTotalCount 0보다 크면 증가 (한페이지에 게시물 3개 , 게시물이 3개 이상이면 페이지 생성)
	}
	
	}

	public int getMemberTotalCount() {
		return memberTotalCount;
	}

	public int getMemberCountPerPage() {
		return memberCountPerPage;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	@Override
	public String toString() {
		return "MemberListView [memberTotalCount=" + memberTotalCount + ", memberCountPerPage=" + memberCountPerPage
				+ ", memberList=" + memberList + ", pageTotalCount=" + pageTotalCount + ", firstRow=" + firstRow
				+ ", pageNumber=" + pageNumber + "]";
	}
	
	

	
}
