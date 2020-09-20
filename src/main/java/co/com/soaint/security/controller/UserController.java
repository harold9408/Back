package co.com.soaint.security.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.soaint.dao.Message;
import co.com.soaint.security.dto.JwtDto;
import co.com.soaint.security.dto.LoginUser;
import co.com.soaint.security.dto.NewUser;
import co.com.soaint.security.entity.User;
import co.com.soaint.security.jwt.JwtProvider;
import co.com.soaint.security.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService usuarioService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Validated @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreUsuario(newUser.getNombreUsuario()))
            return new ResponseEntity(new Message("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(new Message("ese email ya existe"), HttpStatus.BAD_REQUEST);
        User user =
                new User(newUser.getNombre(), newUser.getNombreUsuario(), newUser.getEmail(),
                        passwordEncoder.encode(newUser.getPassword())); 
        usuarioService.save(user);
        return new ResponseEntity(new Message("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Validated @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getNombreUsuario(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
