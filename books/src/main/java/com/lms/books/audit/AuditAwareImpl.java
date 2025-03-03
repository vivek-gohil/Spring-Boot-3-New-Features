package com.lms.books.audit;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    private static final Logger logger = Logger.getLogger(AuditAwareImpl.class.getName());

    public AuditAwareImpl() {
        logger.info("AuditAwareImpl bean created");
    }

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("BOOKS-MS");
    }


}
