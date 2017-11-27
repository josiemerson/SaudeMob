package auxGenesys.example.aux_genesys.service;

import auxGenesys.example.aux_genesys.Util.Log;
import auxGenesys.example.aux_genesys.exception.GenesysException;
import auxGenesys.example.aux_genesys.model.User;
import auxGenesys.example.aux_genesys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    //BCryptPasswordEncoder bCryptPasswordEncoder;
    public void saveUser(User user) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }





    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User validateUser(Log log) {
        User user = userRepository.findOneByEmail(log.getEmail());

        return user.getPassword().equals(log.getPassword())? user:null;
    }

    public boolean deleteUser(User user){
        GenesysException gnex=new GenesysException();
        try{
            userRepository.delete(user);
            return true;
        }catch (Exception ex) {
            return false;
        }
    }

    public boolean deleteUserByEmail(String email){
        try {
            User user = userRepository.findOneByEmail(email);
            userRepository.delete(user);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public User findByEmail(String email){
        try{
            return userRepository.findOneByEmail(email);
        } catch(Exception ex){
            return null;
        }
    }

    public List<User> findByMedicals(){
    	try{
    		return userRepository.findByOfficeIsNotNull();
    	} catch(Exception ex){
    		return null;
    	}
    }

    public boolean updateUser(User user){
        try{
            User aux_user =  userRepository.findOne(user.getId());
            if(aux_user != null){
                userRepository.save(user);
                return true;
            }
            return false;

        } catch(Exception ex){
            return false;
        }
    }
}
