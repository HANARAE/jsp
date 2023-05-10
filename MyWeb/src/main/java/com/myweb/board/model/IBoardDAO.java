package com.myweb.board.model;

import java.util.List;

import com.myweb.board.commons.PageVO;

public interface IBoardDAO {

	//글 등록 메서드
	void regist(String writer, String title, String content);
	
	//글 전체목록 가져오는 메서드
	List<BoardVO> listBoard();
	
	//글 상세보기 요청을 처리할 메서드
	BoardVO contentBoard(int bId);
	
	//글 수정 요청을 처리할 메서드 (제목, 내용)
	void updateBoard(String title, String content, int bId);
	
	//글 삭제 요청을 처리할 메서드
	void deleteBoard(int bId);
	
	//글 검색 요청을 처리할 메서드
	List<BoardVO> searchBoard(String keyword, String category);
	
	//조회수를 올려주는 메서드
	void upHit(int bId);
	
    // 총 게시물 수를 알려주는 메서드
    int countArticles();

	List<BoardVO> listBoard(PageVO paging);
}
