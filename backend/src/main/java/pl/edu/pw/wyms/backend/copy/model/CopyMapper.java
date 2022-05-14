package pl.edu.pw.wyms.backend.copy.model;

import java.util.List;
import java.util.stream.Collectors;

public class CopyMapper {
    public static CopyDTO mapCopyToCopyDTO(Copy copy) {
        return new CopyDTO(copy.getId(), copy.getBook().getId());
    }

    public static List<CopyDTO> mapCopyListToCopyDTOList(List<Copy> copies) {
        return copies.stream().map(copy -> mapCopyToCopyDTO(copy)).collect(Collectors.toList());
    }

    public static Copy mapCopyDTOToCopy(CopyDTO copy) {
        return new Copy(copy.getId(), null, null);
    }
}
