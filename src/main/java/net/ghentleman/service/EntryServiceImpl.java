package net.ghentleman.service;

import net.ghentleman.dao.EntryDao;
import net.ghentleman.dto.EntryDto;
import net.ghentleman.logic.HashGenerator;
import net.ghentleman.model.Entry;
import net.ghentleman.model.TuplePojo;
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
