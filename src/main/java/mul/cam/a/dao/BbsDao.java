package mul.cam.a.dao;

import java.util.List;

import mul.cam.a.dto.BbsDto;
import mul.cam.a.dto.BbsParam;

public interface BbsDao {
	List<BbsDto> bbslist(BbsParam param);
	int bbsCnt();
	BbsDto getDto(int seq);
	int readcount(int seq); //update의 경우는 수정에 성공한 행의 개수를 반환(실패시 0 반환)
	int addBbs(BbsDto dto); //insert의 경우는 삽입된 행의 개수를 반환
	int maxSeq(BbsDto dto);
	int bbsCnt(BbsParam param);
	int addAnswer(BbsDto dto);
}
