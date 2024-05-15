package space.akko.springbootinit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import space.akko.springbootinit.model.entity.Post;
import space.akko.springbootinit.model.entity.User;

import javax.annotation.Resource;

/**
 * 帖子收藏服务测试
 */
@SpringBootTest
class PostFavourServiceTest {

    private static final User loginUser = new User();
    @Resource private PostFavourService postFavourService;

    @BeforeAll
    static void setUp() {
        loginUser.setId(1L);
    }

    @Test
    void doPostFavour() {
        int i = postFavourService.doPostFavour(1L, loginUser);
        Assertions.assertTrue(i >= 0);
    }

    @Test
    void listFavourPostByPage() {
        QueryWrapper<Post> postQueryWrapper = new QueryWrapper<>();
        postQueryWrapper.eq("id", 1L);
        postFavourService.listFavourPostByPage(Page.of(0, 1), postQueryWrapper, loginUser.getId());
    }
}
