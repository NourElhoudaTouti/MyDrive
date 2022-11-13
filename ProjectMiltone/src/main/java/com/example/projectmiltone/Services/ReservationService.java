package com.example.projectmiltone.Services;

import com.example.projectmiltone.Data.Entities.Reservation;
import com.example.projectmiltone.Data.Entities.ReservationStatus;
import com.example.projectmiltone.Data.Entities.User;
import com.example.projectmiltone.Data.Repositories.ReservationRepository;
import com.example.projectmiltone.Data.Repositories.UserRepository;
import com.example.projectmiltone.Data.dtos.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartService cartService ;

    public List<Reservation> getReservationsByCustomer(long customerId) {
        return reservationRepository.findByCustomer(customerId);
    }


    public void checkout(long userId) {
        User user = userRepository.findById(userId).get();
        Cart cart= cartService.getCart(userId);
        if(cart == null || cart.getTripsTotalPrice()==0)
            return;

        Reservation reservation= new Reservation(cart,user);
        reservationRepository.save(reservation);
        cartService.empty(cart,user.getId());
    }
    public void updateResevationStatus(long reservationId, ReservationStatus newStatus){
        Reservation reservation = reservationRepository.findById(reservationId).get();
        //reservation.updateStatus(newStatus);
        reservationRepository.save(reservation);
    }
}
