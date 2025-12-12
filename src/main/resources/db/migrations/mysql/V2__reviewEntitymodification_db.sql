ALTER TABLE review
    ADD booking_id INT NULL;

ALTER TABLE review
    MODIFY booking_id INT NOT NULL;

ALTER TABLE review
    ADD CONSTRAINT uc_review_booking UNIQUE (booking_id);

ALTER TABLE review
    ADD CONSTRAINT FK_REVIEW_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES booking (id);


ALTER TABLE booking
    DROP COLUMN booking_status;

ALTER TABLE booking
    ADD booking_status VARCHAR(255) NULL;

ALTER TABLE booking
    MODIFY driver_id INT NOT NULL;

ALTER TABLE booking
    MODIFY passenger_id INT NOT NULL;