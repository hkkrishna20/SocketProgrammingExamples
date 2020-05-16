package name.javacode.java.logminer.repo;

import java.util.List;

import name.javacode.java.logminer.domain.AbstractLogRecord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository<T extends AbstractLogRecord> extends JpaRepository<T, Long>{
    public List<T> findByRoot(String root);
}
