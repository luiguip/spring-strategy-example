package com.example.strategyexample.plugin;

import com.example.strategyexample.PaymentType;
import jakarta.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MercadoPagoPluginService implements PaymentPlugin {

  private static final Logger logger = LoggerFactory.getLogger(MercadoPagoPluginService.class);

  @Override
  public void process() {
    logger.info("Plugin strategy: {}", PaymentType.MERCADO_PAGO);
  }

  @Override
  public boolean supports(@Nullable PaymentType paymentType) {
    return paymentType == PaymentType.MERCADO_PAGO;
  }
}
