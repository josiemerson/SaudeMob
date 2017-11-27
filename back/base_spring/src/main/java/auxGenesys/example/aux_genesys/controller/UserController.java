package auxGenesys.example.aux_genesys.controller;

import auxGenesys.example.aux_genesys.Util.Log;
import auxGenesys.example.aux_genesys.model.User;
import auxGenesys.example.aux_genesys.service.UserService;
//import net.minidev.json.JSONObject;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@CrossOrigin//(origins = "*")
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/new")//----------------------------SAVE-USER-USANDO-ERROS-HTTP----------------------------
    public ResponseEntity save(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return new ResponseEntity<JSONPObject>(HttpStatus.CONFLICT);
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro "+e);
        }
    }

    @GetMapping("/list")//-------------------------------------------LIST ALL USERS-----------------------
    public ResponseEntity getUser() {
        try {
            List<User> users = userService.getAll();
            return users == null ?
                    ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao ha usuarios cadastrados")
                    : ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/list/medicals")//-------------------------------------------LIST ALL MEDICALS-----------------------
    public ResponseEntity getMedicals() {
    	try {
    		List<User> users = userService.findByMedicals();
    		return users == null ?
    				ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao ha medicos cadastrados")
    				: ResponseEntity.ok(users);
    	} catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
    	}
    }

    @PostMapping("/login")//-----------------------------------GET-USER-BY-EMAIL------------------
    public ResponseEntity getByEmail(@RequestBody Log log) {
        try {
            return userService.validateUser(log)!=null?
                    ResponseEntity.ok(userService.validateUser(log))
                    : ResponseEntity.status(306).body("Teste not ok");
                    //: ResponseEntity.status(10).body("Nao encontrado ou senha incorreta!");
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro 1: " + ex.getMessage());
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro 2: " + ex.getMessage());
        }
    }





    @PostMapping("/delete")
    public ResponseEntity deleteUser(@RequestBody User user){
        try{
            return ResponseEntity.ok(userService.deleteUser(user));
        }catch(Exception ex){
            return new ResponseEntity<JSONPObject>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/deleteByEmail")
    public ResponseEntity deleteUserByEmail(@RequestBody String email){
        try{
            return ResponseEntity.ok(userService.deleteUserByEmail(email));
        }catch(Exception ex){
            return new ResponseEntity<JSONPObject>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/findByEmail")
    public ResponseEntity findByEmail(@RequestBody User user){
        try{
            return userService.findByEmail(user.getEmail())!=null ? ResponseEntity.ok(userService.findByEmail(user.getEmail())) :
                    new ResponseEntity<JSONPObject>(HttpStatus.NOT_FOUND);
        }catch(Exception ex){
            return new ResponseEntity<JSONPObject>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateUser(@RequestBody User user){
        try{
            return userService.updateUser(user) ? ResponseEntity.ok(user) :
                    new ResponseEntity<JSONPObject>(HttpStatus.METHOD_NOT_ALLOWED);
        }catch(Exception ex){
            return new ResponseEntity<JSONPObject>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/findName")
    public ResponseEntity findNameByEmail(@RequestBody User user){
        try{
            User aux_user = userService.findByEmail(user.getEmail());
            return aux_user.getPassword() == user.getPassword() ?
                    ResponseEntity.ok(aux_user) : new ResponseEntity<JSONPObject>(HttpStatus.NOT_FOUND);
        } catch(Exception ex){
            return new ResponseEntity<JSONPObject>(HttpStatus.CONFLICT);
        }
    }
}