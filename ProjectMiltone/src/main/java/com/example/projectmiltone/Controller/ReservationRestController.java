package com.example.projectmiltone.Controller;

import com.example.projectmiltone.Data.Entities.Reservation;
import com.example.projectmiltone.Data.Entities.ReservationStatus;
import com.example.projectmiltone.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/Reservation")
public class ReservationRestController {
    @Autowired
    ReservationService reservationService;

    @GetMapping("/list")
    public List<Reservation> getReservationsByCustomer() {
        long customerId = 1; //To be removed
        return reservationService.getReservationsByCustomer(customerId);
    }

    @GetMapping("/checkout")
    public void checkout() {
        long customerId = 1; //To be removed
        reservationService.checkout(customerId);
    }

    @GetMapping("/backOffice/list")
    public List<Reservation> getOrdersByCustomer(@RequestParam long customerId) {
        return reservationService.getReservationsByCustomer(customerId);
    }

    @GetMapping("/backOffice/updateStatus")
    public void updateOrderStatus(@RequestParam long reservationId, @RequestParam int newStatus) {
        switch (newStatus) {
            case 1:
                reservationService.updateResevationStatus(reservationId, ReservationStatus.DONE);
                break;
            case 2:
                reservationService.updateResevationStatus(reservationId, ReservationStatus.HANDLING);
                break;
            case 3:
                reservationService.updateResevationStatus(reservationId, ReservationStatus.ONHOLD);
                break;
            case 4:
                reservationService.updateResevationStatus(reservationId, ReservationStatus.CANCELED);
                break;


        }
    }
}
