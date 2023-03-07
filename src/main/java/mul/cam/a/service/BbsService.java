package mul.cam.a.service;

import java.util.List;

import mul.cam.a.dto.BbsDto;
import mul.cam.a.dto.BbsParam;

public interface BbsService {
	List<BbsDto> bbslist(BbsParam param);
	int bbsCnt();
	BbsDto getDto(int seq);
	int readcount(int seq);
	boolean addBbs(BbsDto dto);
	int maxSeq(BbsDto dto);
	int bbsCnt(BbsParam param);
	boolean addAnswer(BbsDto dto);
}
