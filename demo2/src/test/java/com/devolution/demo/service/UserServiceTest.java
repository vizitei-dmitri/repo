package com.devolution.demo.service;

import com.devolution.demo.entity.User;
import com.devolution.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


//    @BeforeEach
//    void setup(){
//        userRepository=mock(UserRepository.class);
//        userService=new UserService(userRepository);
//    }

    @Captor
    private ArgumentCaptor<User> integerArgumentCaptor;

    @Test
    void testUserWasNotFound() {}

    @Test
    void testUserWasFound() {

        //Setup
        User user = new User();
        user.setAge(21);
        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));


        //ACT
//        String result = userService.deleteUser(1L);

       Exception exception= assertThrows(Exception.class,()->{
            userService.deleteUser(1L);
        });

        //Check
        assertThat(exception.getMessage()).isEqualTo("User was not deleted successfully");
        verify(userRepository).findById(1L);
        verify(userRepository).delete(integerArgumentCaptor.capture());
        assertThat(integerArgumentCaptor.getValue()).isEqualTo(user);

        assertThrows(Exception.class,()->{
            userService.deleteUser(1L);
        });

    }

}