package auxGenesys.example.aux_genesys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import auxGenesys.example.aux_genesys.service.CoordinatesService;
//import net.minidev.json.JSONObject;


@Controller
@CrossOrigin//(origins = "*")
@RequestMapping("/user/")
public class CoordinatesController {

    private CoordinatesService coordinatesService;

    @Autowired
    public CoordinatesController(CoordinatesService coordinatesService) {
        this.coordinatesService = coordinatesService;
    }


//    public ResponseEntity updateUser(@RequestBody User user){
//        try{
//            return userService.updateUser(user) ? ResponseEntity.ok(user) :
//                    new ResponseEntity<JSONPObject>(HttpStatus.METHOD_NOT_ALLOWED);
//        }catch(Exception ex){
//            return new ResponseEntity<JSONPObject>(HttpStatus.CONFLICT);
//        }
//    }

//    @PostMapping("/findName")
//    public ResponseEntity findNameByEmail(@RequestBody User user){
//        try{
//            User aux_user = userService.findByEmail(user.getEmail());
//            return aux_user.getPassword() == user.getPassword() ?
//                    ResponseEntity.ok(aux_user) : new ResponseEntity<JSONPObject>(HttpStatus.NOT_FOUND);
//        } catch(Exception ex){
//            return new ResponseEntity<JSONPObject>(HttpStatus.CONFLICT);
//        }
//    }
}