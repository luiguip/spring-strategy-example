package com.example.strategyexample.plugin;

import com.example.strategyexample.PaymentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PixPluginService implements PaymentPlugin {

  private static final Logger logger = LoggerFactory.getLogger(PixPluginService.class);

  @Override
  public void process() {
    logger.info("Plugin strategy: {}", PaymentType.PIX);
  }

  @Override
  public boolean supports(PaymentType paymentType) {
    return paymentType == PaymentType.PIX;
  }
}
