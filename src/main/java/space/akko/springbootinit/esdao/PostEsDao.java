package space.akko.springbootinit.esdao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import space.akko.springbootinit.model.dto.post.PostEsDTO;

import java.util.List;

/**
 * 帖子 ES 操作
 */
public interface PostEsDao extends ElasticsearchRepository<PostEsDTO, Long> {

    List<PostEsDTO> findByUserId(Long userId);
}
