-- 테이블 삭제 쿼리
DROP TABLE IF EXISTS datatbl;

-- 테이블 생성 쿼리
CREATE TABLE IF NOT EXISTS datatbl(
	m_code INT AUTO_INCREMENT PRIMARY KEY,
    m_str VARCHAR(20) NOT NULL,
    m_int INT NOT NULL,
    m_date DATE NOT NULL
);

