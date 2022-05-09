package com.controller;


import com.helpers.DefaultResponse;
import com.helpers.LoginResponse;
import com.model.dto.LoginDto;
import com.model.dto.RoleDto;
import com.model.dto.UserDto;
import com.model.entity.Role;
import com.model.entity.User;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.service.RoleService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/auth")
public class AuthController {
    @Autowired
    public RoleService roleService;

    @Autowired
    public UserService userService;

    //==convertDtoToEntity
    public User convertDtoToEntity (UserDto userDto){
        User user= new User();
        user.setIduser(userDto.getIdpengguna());
        user.setEmail(userDto.getEmailpengguna());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setRoleas(userDto.getPeranAs());
        return user;
    }


    //==convertEntityToDto
     public UserDto convertEntityToDto ( User userEntity){
         UserDto userdto= new UserDto();
         userdto.setIdpengguna(userEntity.getIduser());
         userdto.setEmailpengguna(userEntity.getEmail());
         userdto.setFirstName(userEntity.getFirstName());
         userdto.setLastName(userEntity.getLastName());
         userdto.setPassword(userEntity.getPassword());
         return userdto;
    }




    //create date user
    @PostMapping("/register")
    public DefaultResponse read(@RequestBody UserDto userdto){
        User user = convertDtoToEntity(userdto);
        DefaultResponse <UserDto> response = new DefaultResponse<>();
        Optional<User> op = userService.findByEmail(userdto.getEmailpengguna());
        if (op.isPresent()) {
            response.setMessage("Error, email sudah terdaftar");
        } else {
            Optional<Role> peran = roleService.findByRoleIgnoreCase(userdto.getPeranAs());
            if (peran.isPresent()){
                userService.registUser(user);
                response.setMessage("Berhasil daftar, silahkan Sign in");
                response.setData(userdto);
            } else {
                response.setMessage("Peran tidak tersedia. Daftar sebagai admin atau member");
            }
        }
        return response;
    }

    @GetMapping("/list")
    public List<UserDto> getList(){
        List<User> userlist = userService.findAll();
        List<UserDto> userdtolist = userlist.stream().map(this::convertEntityToDto).collect(Collectors.toList());
        return userdtolist;
    }

    @PostMapping("/login")
    public LoginResponse masuk(@RequestBody LoginDto loginDto) {
        LoginResponse resp = new LoginResponse();
        Optional<User> optional = userService.findByPasswordAndEmail(loginDto.getPassword(), loginDto.getEmaillogin());
        if (optional.isPresent()) {
            resp.setPesan("Berhasil login");
        } else {
            resp.setPesan("Email atau Password salah");
        }
        return resp;
    }
}
