package demo.sb.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import demo.sb.restful.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long>{
  
}
