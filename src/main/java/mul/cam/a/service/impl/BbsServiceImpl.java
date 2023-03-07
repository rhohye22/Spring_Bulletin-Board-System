package mul.cam.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.cam.a.dao.BbsDao;
import mul.cam.a.dto.BbsDto;
import mul.cam.a.dto.BbsParam;
import mul.cam.a.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	BbsDao dao;

	@Override
	public List<BbsDto> bbslist(BbsParam param) {
		return dao.bbslist(param);
	}

	@Override
	public int bbsCnt() {
		int count = dao.bbsCnt();
		return count;
	}

	@Override
	public BbsDto getDto(int seq) {
		BbsDto dto = dao.getDto(seq);
		return dto;
	}

	@Override
	public int readcount(int seq) {
		int sec = dao.readcount(seq);
		return sec; // 수정에 성공한 행의 개수를 반환(실패시 0 반환)
	}

	@Override
	public boolean addBbs(BbsDto dto) {
		int sec = dao.addBbs(dto);
		return sec>0?true:false;
	}
	@Override
	public int maxSeq(BbsDto dto) {
		int max = dao.maxSeq(dto);
		return max;
	}
	@Override
	public int bbsCnt(BbsParam param) {
		int cnt = dao.bbsCnt(param);
		return cnt;
	}@Override
	public boolean addAnswer(BbsDto dto) {
		int cnt = dao.addAnswer(dto);
		return cnt>0?true:false;
	}
}
