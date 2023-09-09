package com.example.strategyexample.vanilla;

import com.example.strategyexample.PaymentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("MERCADO_PAGO")
public class MercadoPagoService implements PaymentService {

  private static final Logger logger = LoggerFactory.getLogger(MercadoPagoService.class);

  @Override
  public void process() {
    logger.info("Vanilla strategy: {}", PaymentType.MERCADO_PAGO);
  }
}
