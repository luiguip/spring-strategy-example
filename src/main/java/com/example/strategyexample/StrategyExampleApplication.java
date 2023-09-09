package com.example.strategyexample;

import com.example.strategyexample.plugin.PaymentPlugin;
import com.example.strategyexample.vanilla.PaymentService;
import java.util.Arrays;
import java.util.Map;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.config.EnablePluginRegistries;

@SpringBootApplication
@EnablePluginRegistries(PaymentPlugin.class)
public class StrategyExampleApplication implements CommandLineRunner {

  private final Map<String, PaymentService> paymentServices;
  private final PluginRegistry<PaymentPlugin, PaymentType> paymentPlugins;

  public StrategyExampleApplication(Map<String, PaymentService> paymentServices,
      PluginRegistry<PaymentPlugin, PaymentType> paymentPlugins) {
    this.paymentServices = paymentServices;
    this.paymentPlugins = paymentPlugins;
  }
  public static void main(String[] args) {
    SpringApplication.run(StrategyExampleApplication.class, args);
  }

  @Override
  public void run(String... args) {
    Arrays.stream(PaymentType.values())
        .forEach(p -> {
          paymentServices.get(p.name()).process();
          paymentPlugins.getPluginFor(p).ifPresent(PaymentPlugin::process);
        });
  }
}
