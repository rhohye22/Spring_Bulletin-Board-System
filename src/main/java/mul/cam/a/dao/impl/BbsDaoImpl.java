package mul.cam.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.cam.a.dao.BbsDao;
import mul.cam.a.dto.BbsDto;
import mul.cam.a.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao {

	@Autowired
	SqlSession session;

	@Override
	public List<BbsDto> bbslist(BbsParam param) {
		return session.selectList("Bbs." + "bbslist", param);
	}

	@Override
	public int bbsCnt() {
		return session.selectOne("Bbs." + "bbsCnt");
	}

	@Override
	public BbsDto getDto(int seq) {
		return session.selectOne("Bbs." + "getDto", seq);
	}

	@Override
	public int readcount(int seq) {
		return session.update("Bbs." + "readcount", seq);

	}
	@Override
	public int addBbs(BbsDto dto) {
		return session.insert("Bbs." + "addBbs", dto);
	}
	@Override
	public int maxSeq(BbsDto dto) {
		return session.selectOne("Bbs." + "addStringBbs", dto);
	}
	@Override
	public int bbsCnt(BbsParam param) {
		return session.selectOne("Bbs." + "bbsCnt", param);
	}@Override
	public int addAnswer(BbsDto dto) {
		return session.insert("Bbs." + "addAnswer", dto);
	}
}
