package com.fpmislata.bookstore.controller.user;

import com.fpmislata.bookstore.common.config.PropertiesConfig;
import com.fpmislata.bookstore.controller.common.PaginatedResponse;
import com.fpmislata.bookstore.controller.user.webmodel.GameCollection;
import com.fpmislata.bookstore.controller.user.webmodel.GameCollectionMapper;
import com.fpmislata.bookstore.controller.user.webmodel.GameDetail;
import com.fpmislata.bookstore.controller.user.webmodel.GameDetailMapper;
import com.fpmislata.bookstore.domain.model.Game;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.usecase.game.GameGetAllUseCase;
import com.fpmislata.bookstore.domain.usecase.game.GameGetGameByGameCodeUseCase;
import com.fpmislata.bookstore.domain.usecase.game.GameInsertGame;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/games")
public class GameController {

    public static final String URL = PropertiesConfig.getSetting("app.api.path") + "/games";
    private final String defaultPageSize = PropertiesConfig.getSetting("app.pageSize.default");

    private final GameGetAllUseCase gameGetAllUseCase;
    private final GameGetGameByGameCodeUseCase gameGetGameByGameCodeUseCase;
    private final GameInsertGame gameInsertGame;

    @GetMapping
    public ResponseEntity<PaginatedResponse<GameCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {

        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        String baseUrl = PropertiesConfig.getSetting("app.base.url") + URL;
        ListWithCount<Game> gameListWithCount = gameGetAllUseCase.execute(page - 1, pageSize);
        PaginatedResponse<GameCollection> response = new PaginatedResponse<>(
                gameListWithCount
                        .getList()
                        .stream()
                        .map(GameCollectionMapper.INSTANCE::toGameCollection)
                        .toList(),
                gameListWithCount.getCount(), page, pageSize, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{gameCode}")
    public ResponseEntity<GameDetail> findByIsbn(@PathVariable String gameCode) {
        GameDetail gameDetail = GameDetailMapper.INSTANCE.toGameDetail(gameGetGameByGameCodeUseCase.execute(gameCode));
        return new ResponseEntity<>(gameDetail, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Game game) {
        gameInsertGame.execute(game);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
