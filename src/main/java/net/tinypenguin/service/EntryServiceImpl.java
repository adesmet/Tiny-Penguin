package net.tinypenguin.service;

import net.tinypenguin.dao.EntryDao;
import net.tinypenguin.dto.EntryDto;
import net.tinypenguin.model.TuplePojo;
import net.tinypenguin.logic.HashGenerator;
import net.tinypenguin.model.Entry;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.TreeSet;

@Service
public class EntryServiceImpl implements EntryService {
    @Resource
    private EntryDao entryDao;

    @Override
    public List<EntryDto> processEntry(EntryDto entryDto) {
        TreeSet<TuplePojo> sortedTuples = HashGenerator.sortTuples(entryDto.getTuples());
        List<String> backEndHashes = HashGenerator.generateBackEndHashes(sortedTuples);
        String frontEndHash = HashGenerator.generateFrontEndHash(sortedTuples);

        List<Entry> entriesByHash = entryDao.findEntriesByHash(frontEndHash);

        entryDao.save(entryDto.toEntry(backEndHashes));

        return EntryDto.fromEntries(entriesByHash);
    }

    @Override
    public List<EntryDto> getEntriesWithoutSaving(EntryDto entryDto) {
        TreeSet<TuplePojo> sortedTuples = HashGenerator.sortTuples(entryDto.getTuples());
        String frontEndHash = HashGenerator.generateFrontEndHash(sortedTuples);

        List<Entry> entriesByHash = entryDao.findEntriesByHash(frontEndHash);

        return EntryDto.fromEntries(entriesByHash);
    }
}
