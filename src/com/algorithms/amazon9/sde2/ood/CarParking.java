package com.algorithms.amazon9.sde2.ood;

import java.util.List;

/**
 * Created on 25/04/2017
 *
 * @author Ming Li
 */
public class CarParking {
    
    static enum ParkingStatus {
        FULL, Normal
    }
    
    static class ParkingLot {
        private List<ParkingSpace> parkingSpaces;
        private Entrance entrance;
        private ParkingLotSign sign;
        
        public ParkingLot(List<ParkingSpace> parkingSpaces, Entrance entrance, ParkingLotSign sign) {
            this.parkingSpaces = parkingSpaces;
            this.entrance = entrance;
            this.sign = sign;
        }
        
        public boolean take(ParkingSpace space) {
            if (space.isVacant()) {
                space.setVacant(false);
                return true;
            } else {
                return false;
            }
        }
        
        public boolean vacate(ParkingSpace space) {
            space.setVacant(true);
            return true;
        }
        
        private void updateParkingLotSign() {
            int count = 0;
            for (ParkingSpace space : parkingSpaces) {
                if (space.isVacant()) {
                    count++;
                }
            }
            if (count > 0) {
                sign.setStatus(ParkingStatus.Normal);
            } else {
                sign.setStatus(ParkingStatus.FULL);
            }
            sign.setAvailableSpaces(count);
        }
    }
    
    static class ParkingLotSign {
        private ParkingStatus status;
        private int availableSpaces;
        
        public ParkingStatus getStatus() {
            return status;
        }
        
        public void setStatus(ParkingStatus status) {
            this.status = status;
        }
        
        public int getAvailableSpaces() {
            return availableSpaces;
        }
        
        public void setAvailableSpaces(int availableSpaces) {
            this.availableSpaces = availableSpaces;
        }
        
    }
    
    static class A {
        int a;
        int b;
        int c;
        int d;
        ParkingLot parkingLot;
        
        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + c;
            result = 31 * result + d;
            result = 31 * result + parkingLot.hashCode();
            return result;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            
            A a1 = (A) o;
    
            if (a != a1.a) {
                return false;
            }
            if (b != a1.b) {
                return false;
            }
            if (c != a1.c) {
                return false;
            }
            if (d != a1.d) {
                return false;
            }
            return parkingLot.equals(a1.parkingLot);
        }
    }
    
    static class ParkingSpace {
        private boolean vacant;
        
        public boolean isVacant() {
            return vacant;
        }
        
        public void setVacant(boolean vacant) {
            this.vacant = vacant;
        }
    }
    
    static class Entrance {
        
    }
}
